package com.xingwang.swip.utils;

import android.os.Environment;

import java.io.File;

public class Constants {

    // public static String IP = "http://192.168.65.74/xwapp/public/";
    public static String IP = "http://zyapp.test.xw518.com/";

    public final static String INTENT_DATA = "data";
    public final static String INTENT_DATA1 = "data1";

    public final static String VIDEO_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator + "im";

    /**********圈子模块***********/
    public static String HTTP_BBS = IP + "bbs/";
    /**
     * 图片选择最大张数
     */
    public final static int MAX_COUNT = 9;
    /***帖子详情显示的点赞列表*/
    public final static int MAX_DIGG_NUM = 4;
    /**
     * 来源-所有栏目
     */
    public final static int ALL_CIRCLE = 500;
    /**
     * 来源-发帖
     */
    public final static int POST_CARD = 7;

    public final static String CIRCLE_FORUM = HTTP_BBS + "general/forum/lists";
    public final static String CIRCLE_POST = HTTP_BBS + "user/thread/publish";
    public final static String CARD_LIST = HTTP_BBS + "general/thread/lists";
    public final static String CARD_INFO = HTTP_BBS + "general/thread/get";//帖子详情

    public final static String DIGG = IP + "digg/user/api/digg";//点赞
    public final static String UN_DIGG = IP + "digg/user/api/unDigg";//取消点赞

    public final static String COLLECT = IP + "favorite/user/api/favorite";//收藏
    public final static String UN_COLLECT = IP + "favorite/user/api/unFavorite";//取消收藏

    public final static String USEFUL_COMMENT = HTTP_BBS + "general/comment/recommended";//精选评论
    public final static String COMMENT = HTTP_BBS + "general/comment/lists";//评论
    public final static String COMMENT_INFO = HTTP_BBS + "general/comment/detail";//评论详情

    public final static String SEND_COMMENT = HTTP_BBS + "user/comment/publish";//发布评论

    public final static String DIGG_LIST = IP + "digg/general/api/lists";//点赞列表


    /*********************文章模块***************/

    public static String HTTP_ESSAY = IP + "article/general/article/";
    public static String HTTP_COLLECT = IP + "favorite/user/api/";

    public final static String ESSAY_CATALOG = IP + "article/general/category/lists";
    public final static String ESSAY_LIST = HTTP_ESSAY + "lists";
    public final static String ESSAY_INFO = HTTP_ESSAY + "detail";

    public final static String ESSAY_IS_COLLECT = HTTP_COLLECT + "isFavorite";
    public final static String ESSAY_COLLECT = HTTP_COLLECT + "favorite";
    public final static String ESSAY_UNCOLLECT = HTTP_COLLECT + "unFavorite";
    public final static String ESSAY_SHARE = IP + "page/share_article?id=";

    /**********群聊模块***********/
    public static String HTTP_GROUP = IP + "group/user/group/";
    //其他
    public static String HTTP_GENERAL = IP + "user/general/user/";

    //获取我加入的群
    public final static String GROUP_MY=HTTP_GROUP+"my";
    //获取群成员
    public final static String GROUP_MEMBER=HTTP_GROUP+"user";
    //获取群信息
    public final static String GROUP_INFO=HTTP_GROUP+"info";
    //修改群信息
    public final static String GROUP_EDIT=HTTP_GROUP+"edit";
    //创建群
    public final static String GROUP_CREATE=HTTP_GROUP+"create";
    //退出群聊
    public final static String GROUP_LEAVE=HTTP_GROUP+"leave";
    //解散群聊
    public final static String GROUP_DISMISS=HTTP_GROUP+"dismiss";
    //拉人进群
    public final static String GROUP_ADD=HTTP_GROUP+"laren";
    //踢出群聊
    public final static String GROUP_MEMBER_REMOVE=HTTP_GROUP+"tiren";
    //转移群
    public final static String GROUP_TRANSFER=HTTP_GROUP+"zengsong";

    //根据电话号码搜索用户
    public final static String SEARCH_USER=HTTP_GENERAL+"search";

    //根据电话号码搜索用户
    public final static String USER_INFO=HTTP_GENERAL+"info";
}
