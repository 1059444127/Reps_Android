package com.example.ustc.healthreps.database.impl;

import android.content.Context;

import com.example.ustc.healthreps.database.DBConstants;
import com.example.ustc.healthreps.database.support.DaoSupportImpl;
import com.example.ustc.healthreps.database.entity.Cookie;
import com.example.ustc.healthreps.utils.Utils;

import java.util.ArrayList;

/**
 * Created by CaoRuijuan on 12/22/15.
 */
public class CookieDaoImpl extends DaoSupportImpl<Cookie>{
    private Context context;

    public CookieDaoImpl(Context context){
        super(context,"user");
        this.context = context;
    }

    //判断某用户是否在cookie表中
    public boolean checkUsernameExist(String username){
        String selector = DBConstants.COOKIE_USERNAME + "=?";
        String[] selectorargs = new String[]{username};
        if(findEntity(selector,selectorargs).size() == 0)
            return false;
        else
            return true;
    }

    //添加新用户cookie
    public boolean addNewUserToCookie(String username,byte[] pwd, int type){
        String nameStr = username;
        String pwdStr = new String(pwd);
        String typeStr = String.valueOf(type);

        Cookie cookie = new Cookie(nameStr,pwdStr,typeStr,typeStr);
        return insert(cookie);
    }

    //删除
    public boolean removeUserFromCookie(String username){
        int id = getIDByColumnValue(DBConstants.DB_NAME_USER,username);
        if(id != -1)
            return delete(id);
        else
            return false;
    }

    //更新时间
    public boolean updateDate(int id){
        return updateItems(id,new String[]{DBConstants.COOKIE_DATE}, new String[]{Utils.getDate()});
    }
}
