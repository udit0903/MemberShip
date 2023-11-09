package com.pinaka.MemberShip.utils;

public class Constants {

    public static final String VERSION="v3";
    public static final String ALL_PERSON_GET_URL= "/"+VERSION+"/home/allPerson";

    public static final String   API_TYPE_RESPONSE="application/json";
    public static final String   API_TYPE_RESPONSE2= "multipart/form-data";

    public static final String ADD_PERSON_PUT_URL= "/"+VERSION+"/addPerson";

    public static final String PERSON_BY_ID_GET_URL= "/"+VERSION+"/home/allPerson/personById";
    public static final String UPDATE_FEE_BY_PERSSON_ID_PUT_URL= "/"+VERSION+"/feeByPersonId";

    public static final String UPDATE_PROFILE_BY_PERSSON_ID_PUT_URL= "/"+VERSION+"/profileByPersonId";
    public static final String     OWNER_DETAILS_GET_URL= "/"+VERSION+"/ownerDetails";



    public static final String UPDATE_FEE_BY_OWNER_ID_PUT_URL= "/"+VERSION+"/feeByOwnerId";

    public static final String UPDATE_PROFILE_BY_OWNER_ID_PUT_URL= "/"+VERSION+"/profileByOwnerId";

    public static final String FILTER_BY_MOBILE_AND_NAME_POST_URL= "/"+VERSION+"/filterByMobileAndName";

    public static final String FEE_PENDING_GET_URL= "/"+VERSION+"/feePending";
    public static final String DATE_PATTERN="dd-MM-yyyy";







}
