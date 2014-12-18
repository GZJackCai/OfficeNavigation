package com.richard.officenavigation.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.richard.officenavigation.dao.IMap;
import com.richard.officenavigation.dao.INode;
import com.richard.officenavigation.dao.IPath;
import com.richard.officenavigation.dao.Beacon;

import com.richard.officenavigation.dao.IMapDao;
import com.richard.officenavigation.dao.INodeDao;
import com.richard.officenavigation.dao.IPathDao;
import com.richard.officenavigation.dao.BeaconDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig iMapDaoConfig;
    private final DaoConfig iNodeDaoConfig;
    private final DaoConfig iPathDaoConfig;
    private final DaoConfig beaconDaoConfig;

    private final IMapDao iMapDao;
    private final INodeDao iNodeDao;
    private final IPathDao iPathDao;
    private final BeaconDao beaconDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        iMapDaoConfig = daoConfigMap.get(IMapDao.class).clone();
        iMapDaoConfig.initIdentityScope(type);

        iNodeDaoConfig = daoConfigMap.get(INodeDao.class).clone();
        iNodeDaoConfig.initIdentityScope(type);

        iPathDaoConfig = daoConfigMap.get(IPathDao.class).clone();
        iPathDaoConfig.initIdentityScope(type);

        beaconDaoConfig = daoConfigMap.get(BeaconDao.class).clone();
        beaconDaoConfig.initIdentityScope(type);

        iMapDao = new IMapDao(iMapDaoConfig, this);
        iNodeDao = new INodeDao(iNodeDaoConfig, this);
        iPathDao = new IPathDao(iPathDaoConfig, this);
        beaconDao = new BeaconDao(beaconDaoConfig, this);

        registerDao(IMap.class, iMapDao);
        registerDao(INode.class, iNodeDao);
        registerDao(IPath.class, iPathDao);
        registerDao(Beacon.class, beaconDao);
    }
    
    public void clear() {
        iMapDaoConfig.getIdentityScope().clear();
        iNodeDaoConfig.getIdentityScope().clear();
        iPathDaoConfig.getIdentityScope().clear();
        beaconDaoConfig.getIdentityScope().clear();
    }

    public IMapDao getIMapDao() {
        return iMapDao;
    }

    public INodeDao getINodeDao() {
        return iNodeDao;
    }

    public IPathDao getIPathDao() {
        return iPathDao;
    }

    public BeaconDao getBeaconDao() {
        return beaconDao;
    }

}