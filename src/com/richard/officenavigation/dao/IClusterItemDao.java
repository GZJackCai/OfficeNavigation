package com.richard.officenavigation.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.richard.officenavigation.dao.IClusterItem;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table ICLUSTER_ITEM.
*/
public class IClusterItemDao extends AbstractDao<IClusterItem, Long> {

    public static final String TABLENAME = "ICLUSTER_ITEM";

    /**
     * Properties of entity IClusterItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ClusterId = new Property(1, long.class, "clusterId", false, "CLUSTER_ID");
        public final static Property Minor = new Property(2, int.class, "minor", false, "MINOR");
        public final static Property MapId = new Property(3, long.class, "mapId", false, "MAP_ID");
    };

    private Query<IClusterItem> iCluster_ItemsQuery;

    public IClusterItemDao(DaoConfig config) {
        super(config);
    }
    
    public IClusterItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'ICLUSTER_ITEM' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'CLUSTER_ID' INTEGER NOT NULL ," + // 1: clusterId
                "'MINOR' INTEGER NOT NULL ," + // 2: minor
                "'MAP_ID' INTEGER NOT NULL );"); // 3: mapId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'ICLUSTER_ITEM'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, IClusterItem entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getClusterId());
        stmt.bindLong(3, entity.getMinor());
        stmt.bindLong(4, entity.getMapId());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public IClusterItem readEntity(Cursor cursor, int offset) {
        IClusterItem entity = new IClusterItem( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // clusterId
            cursor.getInt(offset + 2), // minor
            cursor.getLong(offset + 3) // mapId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, IClusterItem entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setClusterId(cursor.getLong(offset + 1));
        entity.setMinor(cursor.getInt(offset + 2));
        entity.setMapId(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(IClusterItem entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(IClusterItem entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "items" to-many relationship of ICluster. */
    public List<IClusterItem> _queryICluster_Items(long clusterId) {
        synchronized (this) {
            if (iCluster_ItemsQuery == null) {
                QueryBuilder<IClusterItem> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ClusterId.eq(null));
                iCluster_ItemsQuery = queryBuilder.build();
            }
        }
        Query<IClusterItem> query = iCluster_ItemsQuery.forCurrentThread();
        query.setParameter(0, clusterId);
        return query.list();
    }

}
