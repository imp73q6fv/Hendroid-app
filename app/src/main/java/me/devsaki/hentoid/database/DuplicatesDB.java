package me.devsaki.hentoid.database;

import android.content.Context;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import me.devsaki.hentoid.database.domains.DuplicateEntry;

public class DuplicatesDB {

    //private static final File DB_DIRECTORY = new File("duplicates-db");
    private static final String DB_NAME = "duplicates-db";

    private static DuplicatesDB instance;

    private final Realm realm;


    private DuplicatesDB(Context context) {
        realm = Realm.getDefaultInstance();
    }

    // Use this to get db instance
    public static synchronized DuplicatesDB getInstance(Context context) {
        // Use application context only
        if (instance == null) {
            instance = new DuplicatesDB(context);
        }

        return instance;
    }

    void closeThreadResources() {
        clearEntries();
    }

    long getDbSizeBytes() {
        return 1;
    }

    public void tearDown() {
        realm.delete(DuplicateEntry.class);
    }

    public RealmQuery<DuplicateEntry> selectEntriesQ() {
        return realm.where(DuplicateEntry.class);
    }

    void insertEntry(DuplicateEntry entry) {
        realm.executeTransaction(r -> {
            r.insertOrUpdate(entry);
        });
    }

    void insertEntries(List<DuplicateEntry> entry) {
        realm.executeTransaction(r -> {
            r.insertOrUpdate(entry);
        });
    }

    void delete(DuplicateEntry entry) {
        realm.executeTransaction(r -> {
            entry.deleteFromRealm();
        });
    }

    void clearEntries() {
        realm.executeTransaction(r -> {
            realm.delete(DuplicateEntry.class);
        });
    }
}
