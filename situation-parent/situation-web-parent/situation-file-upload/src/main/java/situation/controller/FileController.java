package situation.controller;

import com.situation.entity.Result;
import com.situation.entity.Status;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件相关
 * @author lgd
 * @date 2021/10/30 16:00
 */
@RestController
@RequestMapping("/file")
public class FileController {
    /**
     * 上传是上传什么 ？
     * @param multipartFile
     * @return
     */
    @RequestMapping("/upload")
    public Result fileUpload(@RequestParam("excel")MultipartFile multipartFile){


        return new Result(true, Status.SUCCESS,"上传成功");
    }
}
