package org.telegram.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import org.telegram.dao.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table USER.
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property AccessHash = new Property(1, Long.class, "accessHash", false, "ACCESS_HASH");
        public final static Property FirstName = new Property(2, String.class, "firstName", false, "FIRST_NAME");
        public final static Property LastName = new Property(3, String.class, "lastName", false, "LAST_NAME");
        public final static Property Phone = new Property(4, String.class, "phone", false, "PHONE");
        public final static Property LinkType = new Property(5, int.class, "linkType", false, "LINK_TYPE");
        public final static Property Avatar = new Property(6, byte[].class, "avatar", false, "AVATAR");
        public final static Property Status = new Property(7, byte[].class, "status", false, "STATUS");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'_id' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'ACCESS_HASH' INTEGER," + // 1: accessHash
                "'FIRST_NAME' TEXT NOT NULL ," + // 2: firstName
                "'LAST_NAME' TEXT NOT NULL ," + // 3: lastName
                "'PHONE' TEXT," + // 4: phone
                "'LINK_TYPE' INTEGER NOT NULL ," + // 5: linkType
                "'AVATAR' BLOB," + // 6: avatar
                "'STATUS' BLOB);"); // 7: status
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        Long accessHash = entity.getAccessHash();
        if (accessHash != null) {
            stmt.bindLong(2, accessHash);
        }
        stmt.bindString(3, entity.getFirstName());
        stmt.bindString(4, entity.getLastName());
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        stmt.bindLong(6, entity.getLinkType());
 
        byte[] avatar = entity.getAvatar();
        if (avatar != null) {
            stmt.bindBlob(7, avatar);
        }
 
        byte[] status = entity.getStatus();
        if (status != null) {
            stmt.bindBlob(8, status);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // accessHash
            cursor.getString(offset + 2), // firstName
            cursor.getString(offset + 3), // lastName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // phone
            cursor.getInt(offset + 5), // linkType
            cursor.isNull(offset + 6) ? null : cursor.getBlob(offset + 6), // avatar
            cursor.isNull(offset + 7) ? null : cursor.getBlob(offset + 7) // status
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setAccessHash(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setFirstName(cursor.getString(offset + 2));
        entity.setLastName(cursor.getString(offset + 3));
        entity.setPhone(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setLinkType(cursor.getInt(offset + 5));
        entity.setAvatar(cursor.isNull(offset + 6) ? null : cursor.getBlob(offset + 6));
        entity.setStatus(cursor.isNull(offset + 7) ? null : cursor.getBlob(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
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
    
}
