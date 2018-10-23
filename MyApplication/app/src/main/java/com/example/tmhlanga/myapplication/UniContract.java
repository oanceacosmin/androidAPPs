package com.example.tmhlanga.myapplication;

public final class UniContract
{
    public static String _GROUP;

    private UniContract() { }

    public final class User
    {
        public static final String TABLE_NAME = "_user_";
        public static final String SID = "_sid_";
        public static final String FN = "_fn_";
        public static final String SN = "_sn_";
        public static final String EM = "_em_";
        public static final String GROUP = "_group_";
        public static final String PW = "_pw_";
    }

    public final class Uni_Group
    {
        public static final String TABLE_NAME = "_groupID_";
        public static final String GROUP_ID = "group_id";

    }

}

