package com.samir.android_livedata_preferences.sp1;

public class CacheLiveDataUtil {

    //===============================================================================

    private static SPLiveData1<String> setSharedPreferences(String key, String value) {
       // CacheDataUtil.write(key, value);

       return new SPLiveData1<String>(key, value) {
           @Override
           String getValueFromPreferences(String key, String defValue) {
               return CacheDataUtil.getPreferences().getString(key, defValue);
           }
       };
    }


    //===============================================================================

    private static SPLiveData1<Long> setSharedPreferences(String key, Long value) {
        //CacheDataUtil.write(key, value);

        return new SPLiveData1<Long>(key, value) {
            @Override
            Long getValueFromPreferences(String key, Long defValue) {
                return CacheDataUtil.readLong(key);
            }
        };
    }

    //===============================================================================

    private static SPLiveData1<Integer> setSharedPreferences(String key, Integer value) {
       // CacheDataUtil.write(key, value);

        return new SPLiveData1<Integer>(key, value) {
            @Override
            Integer getValueFromPreferences(String key, Integer defValue) {
                return CacheDataUtil.readInt(key);
            }
        };
    }


    //===============================================================================

    private static SPLiveData1<Boolean> setSharedPreferences(String key, Boolean value) {
       // CacheDataUtil.write(key, value);

        return new SPLiveData1<Boolean>(key, value) {
            @Override
            Boolean getValueFromPreferences(String key, Boolean defValue) {
                return CacheDataUtil.readBoolean(key);
            }
        };
    }
    //===============================================================================

    public static void write(String key, String value) {
        CacheDataUtil.write(key, value);
        setSharedPreferences(key, value);
    }

    public static void write(String key, boolean value) {
        CacheDataUtil.write(key, value);
        setSharedPreferences(key, value);
    }

    public static void write(String key, long value) {
        CacheDataUtil.write(key, value);
        setSharedPreferences(key, value);
    }

    public static void writeInt(String key, int value) {
       CacheDataUtil.write(key, value);
        setSharedPreferences(key, value);
    }

    public static SPLiveData1<String> read(String key) {
        return setSharedPreferences(key, "");
    }

    public static SPLiveData1<Integer> readInt(String key) {
          return setSharedPreferences(key, 0);
    }

    public static SPLiveData1<Long> readLong(String key) {
        return setSharedPreferences(key, 0L);
    }

    public static SPLiveData1<Boolean> readBoolean(String key) {
        return setSharedPreferences(key, false);
    }


}
