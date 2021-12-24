package com.situation.entity;

import com.situation.entity.inter.DefaultPacketParam;

import java.io.Serializable;

/**
 * 数据包载体
 * @author lgd
 * @date 2021/10/27 21:04
 */
public class Packet implements Serializable {


    private String destip;

    private String protocol= DefaultPacketParam.PROTOCOL;

    private String sourceport;

    private String destport =DefaultPacketParam.DEST_PORT;

    private String frequence=DefaultPacketParam.FREQUENT;

    private String message=DefaultPacketParam.MESSAGE;

    private String count=DefaultPacketParam.COUNT;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDestip() {
        return destip;
    }

    public void setDestip(String destip) {
        this.destip = destip;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getSourceport() {
        return sourceport;
    }

    public void setSourceport(String sourceport) {
        this.sourceport = sourceport;
    }

    public String getDestport() {
        return destport;
    }

    public void setDestport(String destport) {
        this.destport = destport;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public Packet() {
//    }
//
//    public Packet(String destIp) {
//        destIp = destIp;
//    }
//
//    public Packet(String destIp, String protocol) {
//        destIp = destIp;
//        this.protocol = protocol;
//    }
//
//
//    public Packet(String destIp, String sourceport, String destport) {
//        destIp = destIp;
//        this.sourceport = sourceport;
//        this.destport = destport;
//    }
//
//    public Packet(String destIp, String protocol, String sourceport, String destport, Integer frequence, String message) {
//        destIp = destIp;
//        this.protocol = protocol;
//        this.sourceport = sourceport;
//        this.destport = destport;
//        this.frequence = frequence;
//        this.message = message;
//    }
}
