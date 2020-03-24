package com.xingwang.swip.utils;

public class Constants {

   // public static String IP = "http://192.168.65.74/xwapp/public/";
    public static String IP = "http://zyapp.test.xw518.com/";

    public final static String INTENT_DATA="data";
    public final static String INTENT_DATA1="data1";

    /**********圈子模块***********/
    public static String HTTP_BBS=IP+"bbs/";
    /**图片选择最大张数*/
    public final static int MAX_COUNT=9;
    /***帖子详情显示的点赞列表*/
    public final static int MAX_DIGG_NUM=4;
    /**来源-所有栏目*/
    public final static int ALL_CIRCLE=500;
    /**来源-发帖*/
    public final static int POST_CARD=7;

    public final static String CIRCLE_FORUM=HTTP_BBS+"general/forum/lists";
    public final static String CIRCLE_POST=HTTP_BBS+"user/thread/publish";
    public final static String CARD_LIST=HTTP_BBS+"general/thread/lists";
    public final static String CARD_INFO=HTTP_BBS+"general/thread/get";//帖子详情

    public final static String DIGG=IP+"digg/user/api/digg";//点赞
    public final static String UN_DIGG=IP+"digg/user/api/unDigg";//取消点赞

    public final static String COLLECT=IP+"favorite/user/api/favorite";//收藏
    public final static String UN_COLLECT=IP+"favorite/user/api/unFavorite";//取消收藏

    public final static String USEFUL_COMMENT=HTTP_BBS+"general/comment/recommended";//精选评论
    public final static String COMMENT=HTTP_BBS+"general/comment/lists";//评论
    public final static String COMMENT_INFO=HTTP_BBS+"general/comment/detail";//评论详情

    public final static String SEND_COMMENT=HTTP_BBS+"user/comment/publish";//发布评论

    public final static String DIGG_LIST=IP+"digg/general/api/lists";//点赞列表


    /*********************文章模块***************/

    public static String HTTP_ESSAY =IP+"article/general/article/";
    public static String HTTP_COLLECT =IP+"favorite/user/api/";

    public final static String ESSAY_CATALOG=IP+"article/general/category/lists";
    public final static String ESSAY_LIST=HTTP_ESSAY+"lists";
    public final static String ESSAY_INFO=HTTP_ESSAY+"detail";

    public final static String ESSAY_IS_COLLECT=HTTP_COLLECT+"isFavorite";
    public final static String ESSAY_COLLECT=HTTP_COLLECT+"favorite";
    public final static String ESSAY_UNCOLLECT=HTTP_COLLECT+"unFavorite";
    public final static String ESSAY_SHARE=IP+"page/share_article?id=";

}
