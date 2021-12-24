package com.situation.entity.inter;

/**
 * 公共信息的默认抽取----
 * @author lgd
 * @date 2021/10/27 21:02
 */
public interface DefaultPacketParam {

    //默认的发送间隔
    final String FREQUENT="1";

    //默认的协议
    final String PROTOCOL="udp";

    final String DEST_PORT="12312";

    //默认携带的数据 可以搞成json
    final String MESSAGE="{\"data\":\"test\"}";

    //默认发10个包
    final String COUNT="5";

}
