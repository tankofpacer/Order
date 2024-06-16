package com.example.Android_bigWork.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.Android_bigWork.Entity.Coupon;

/**
 * @author 
 * @Type CouponDatabase
 * @Desc
 */
@Database(entities = {Coupon.class}, version = 1, exportSchema = false)
public abstract class CouponDatabase extends RoomDatabase {
    private static final String DB_NAME = "coupon.db";
    private static CouponDatabase INSTANCE;

    /**
     * 获取数据库实例
     *
     * @param context 上下文环境
     * @return CouponDatabase
     * @Author 
     * @commit
     */
    public static synchronized CouponDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CouponDatabase.class,
                            DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public abstract CouponDao getCouponDao();
}
