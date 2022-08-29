package com.github.lunarconcerto.umaaudiogui;

import javafx.scene.control.ListView;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class UmaAssetLoader {

    public static final String UMA_ASSET_FOLDER = "C://Users/Administrator/AppData/LocalLow/Cygames/umamusume" ;
    public static final String UMA_META_DB_PATH = UMA_ASSET_FOLDER + "/meta" ;

    private UmaAssetLoader() {}

    public static List<AssetInfo> loadAssetInfo(){
        Dao dao = new NutDao(getDataSource());
        return dao.query(AssetInfo.class, Cnd.where("n" , "like" , "%.awb%") );
    }

    static DataSource getDataSource(){
        try {
            SimpleDataSource dataSource = new SimpleDataSource();
            dataSource.setDriverClassName("org.sqlite.JDBC");
            dataSource.setJdbcUrl("jdbc:sqlite:" + UMA_META_DB_PATH);
            return dataSource ;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
