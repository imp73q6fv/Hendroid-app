package me.devsaki.hentoid.database.domains;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class QueueRecord extends RealmObject {

    @PrimaryKey
    public long id;
    private Content content;
    private int rank;

    public QueueRecord() { // Required by ObjectBox when an alternate constructor exists
    }

    public QueueRecord(long id, int order) {
        content.setId(id);
        rank = order;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
