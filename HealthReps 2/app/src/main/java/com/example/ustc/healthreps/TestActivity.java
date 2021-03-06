package com.example.ustc.healthreps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.example.ustc.healthreps.database.DBConstants;
import com.example.ustc.healthreps.database.impl.CookieDaoImpl;
import com.example.ustc.healthreps.database.entity.Cookie;
import com.example.ustc.healthreps.repo.LoginRepo;
import com.example.ustc.healthreps.serverInterface.NetPack;
import com.example.ustc.healthreps.serverInterface.ReqSingleUserInfo;
import com.example.ustc.healthreps.serverInterface.Types;
import com.example.ustc.healthreps.socket.Sockets;
import com.example.ustc.healthreps.socket.TCPSocket;
import com.example.ustc.healthreps.threads.AllThreads;
import com.example.ustc.healthreps.threads.HeartBeatTask;
import com.example.ustc.healthreps.threads.ReceiveThread;
import com.example.ustc.healthreps.utils.AndroidNetAccess;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by CaoRuijuan on 12/11/15.
 */
public class TestActivity extends Activity {
    private Button recvBtn,testBtn,deleteBtn;
    public static Handler sTestActivityHandler = null;
    private ReceiveThread mReceiveThread = AllThreads.sReceiveThread;
    private Timer mHeatBeatTimer = AllThreads.sHeatBeatTimer;
    private HeartBeatTask mHeartBeatTask = AllThreads.sHeartBeatTask;

    //心跳包相关
    private static Object lock = new Object(); // static确保只有一把锁
    //显示网络状况
    private Button m_connect_alert;
//    public ReceiveThread recv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        new LoginRepo();

//
////
////        initView1();
//
//        //安卓2.3以后访问网络增加内容
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads()
//                .detectDiskWrites()
//                .detectNetwork()
//                .penaltyLog()
//                .build());
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                .detectLeakedSqlLiteObjects()
//                .detectLeakedClosableObjects()
//                .penaltyLog()
//                .penaltyDeath()
//                .build());
//
//        //初始化socket
//        Sockets.socket_center.initSocket();
//
//        //启动接收线程
//        if(mReceiveThread == null){
//            mReceiveThread = new ReceiveThread("Recv_Thread");
//            mReceiveThread.start();
//        }
//        //待登录之后启动心跳包
//        Sockets.socket_center.sendHeartBeat();
//        startHeartBeatThread();

    }

//    //心跳包设计
//    Timer heatBeatTimer;
//    //启动心跳包线程
//    public void startHeartBeatThread (){
//        if(mHeatBeatTimer == null){
//            mHeatBeatTimer = new Timer();
//        }
//        if(mHeartBeatTask == null){
//            mHeartBeatTask = new HeartBeatTask();
//        }
//        mHeatBeatTimer.schedule(mHeartBeatTask, 1000, 5000);
//    }

//    public void initView1(){
//        testBtn = (Button)findViewById(R.id.testBtn);
//        testBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                testGPS();
//            }
//        });
//
//        deleteBtn = (Button)findViewById(R.id.button3);
//        deleteBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteDB();
//            }
//        });
//
//    }
//
//    public void initView(){
//        recvBtn = (Button)findViewById(R.id.button2);
//        recvBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Sockets.socket_center.reqFileList("store1", false, Types.FILE_TYPE_PRES_CHECK);
//                //Sockets.socket_center.reqFileList("store1",false,Types.FILE_TYPE_PRES_CHECK_REJECT);
//                //Sockets.socket_center.reqFileList("store1",false,Types.FILE_TYPE_PRES_LOCAL_UNCHECK);
//                reqUserInfo();
//            }
//        });
//
//        testBtn = (Button)findViewById(R.id.testBtn);
//        testBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                testDB();
//            }
//        });
//
//        deleteBtn = (Button)findViewById(R.id.button3);
//        deleteBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteDB();
//            }
//        });
//
//    }
//
//    //测试数据库
//    public void testDB(){
//        CookieDaoImpl dao = new CookieDaoImpl(this);
//        dao.insert(new Cookie("1", "12", "12", "20151222"));
//        dao.insert(new Cookie("2", "是的", "12", "201512DD"));
//        dao.insert(new Cookie("3", "3222","12",  "201222"));
//
//        ArrayList<Cookie> list;
//
//        dao.delete(2);
//        list = dao.findAll();
//
//        dao.update(new Cookie(3,"3", "为偶们几点睡觉", "12", "201222"));
//        list = dao.findEntity(DBConstants.COOKIE_DATE + " like ?", new String[]{"%2%"});
//        System.out.print(list.size());
//    }
//
//    //删除数据库
//    public void deleteDB(){
//        this.deleteDatabase("user.db");
//
//    }
//
//    //请求登录用户信息
//    public void reqUserInfo(){
//        ReqSingleUserInfo info = new ReqSingleUserInfo();
//        try{
//            info.username = "store1".getBytes("GBK");
//            info.type = Types.USER_TYPE_STORE;
//            info.isPicExist = false;
//        }catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        NetPack p = new NetPack(-1,ReqSingleUserInfo.SIZE,Types.REQ_SINGLE_USER_INFO,info.getReqSingleUserInfoBytes());
//        p.CalCRC();
//        Sockets.socket_center.sendPack(p);
//    }
//
//    //测试GPS
//    public void testGPS(){
//
//    }
}
