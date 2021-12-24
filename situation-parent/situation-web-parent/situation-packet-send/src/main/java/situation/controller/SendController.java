package situation.controller;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import com.alibaba.fastjson.JSON;
import com.situation.entity.Packet;
import com.situation.entity.Result;
import com.situation.entity.Status;
import com.situation.entity.TotalMessage;
import com.situation.util.ConnectToServer;
import com.situation.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import situation.service.SendPacketService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 数据包发送
 * @author lgd
 * @date 2021/10/28 14:53
 */
@RestController
@RequestMapping("/send")
@CrossOrigin
public class SendController {

    @Autowired
    private SendPacketService sendPacketService;

    private File privateKey;
    /**
     * 数据包发送 接手前端json形式的packer对象
     * @param totalMessage
     * @return
     */
    @PostMapping("/send")
    public Result send(@RequestBody (required = false)TotalMessage totalMessage) throws IOException {

        Packet packet = totalMessage.getPacket();
        try {
            sendPacketService.sendPacketByScript(packet);

        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false,Status.ERROR,"发送失败");
        }
        return new Result(true,Status.SUCCESS,"发送成功");
    }


    /**
     * 远程执行脚本  由封装实体的里的packet 里的 protocol 属性决定脚本名(事先在服务端写好的)
     * 私钥前端可以用整个表单传过来  不传就用用户名密码登录
     * @param
     * @return
     * @throws IOException
     */
    @RequestMapping("/sh")
    public Result execScript(@RequestBody (required = false)TotalMessage totalMessage) throws IOException {
//        TotalMessage totalMessage = JSON.parseObject(jsonMessage, TotalMessage.class);
        Packet packet = totalMessage.getPacket();
        try {
            if (privateKey!=null)   sendPacketService.sendPacketByScriptAndConnectionByKey(packet, privateKey);
            else sendPacketService.sendPacketByScript(packet);

        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false,Status.ERROR,"执行脚本失败");
        }
        return new Result(true,Status.SUCCESS,"执行脚本成功");
    }

    /**
     * 没有用！
     * @param add
     * @return
     * @throws IOException
     */
    @GetMapping("/ping")
    public Result test(String add) throws IOException {
        Runtime runtime=Runtime.getRuntime();

        String commadn="ping  "+add;

        Process process = runtime.exec(commadn);

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), "GBK"));// windows下编码默认是GBK，Linux是UTF-8

        String line = null;

        while (null != (line = bufferedReader.readLine())) {

            System.out.println(line);

        }

        bufferedReader.close();
//        InputStream inputStream = process.getInputStream();
//        FileOutputStream fileOutputStream=new FileOutputStream("E:\\test.txt");
//
//
//        byte[]buffer =new byte[1024];
//
//        while (inputStream.read(buffer)!=-1){
//            fileOutputStream.write(buffer);
//        }
//        fileOutputStream.flush();
//        fileOutputStream.close();
//        inputStream.close();

        return new Result(true, Status.SUCCESS,"发送成功");
    }

    /**
     * 接收文件示例  服务器 私钥
     */
    @PostMapping("/upload")
    public Result uploadKey(@RequestParam("keyfile")MultipartFile multipartFile){
        if (multipartFile!=null){
            File file = FileUtils.MultipartFileConvertToFile(multipartFile);
            this.privateKey=file;
            Result res=new Result(true,Status.SUCCESS,"私钥上传成功");
            return res;
//            return new Result(true,Status.SUCCESS,"私钥上传成功");
        }

        return new Result(false,Status.ERROR,"私钥上传失败");
    }
}
