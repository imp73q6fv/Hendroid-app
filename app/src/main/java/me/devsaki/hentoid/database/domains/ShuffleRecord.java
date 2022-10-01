package me.devsaki.hentoid.database.domains;

import javax.annotation.Nullable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ShuffleRecord extends RealmObject {

    @PrimaryKey
    public long id;
    private Long contentId;

    public ShuffleRecord() { // Required by ObjectBox when an alternate constructor exists
    }

    public ShuffleRecord(Long contentId) {
        this.contentId = contentId;
    }

    @Nullable
    public Long getContentId() {
        return contentId;
    }
}
