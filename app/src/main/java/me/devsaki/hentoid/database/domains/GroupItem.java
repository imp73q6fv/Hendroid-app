package me.devsaki.hentoid.database.domains;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class GroupItem extends RealmObject {

    @PrimaryKey
    public long id;
    public Content content;
    public Group group;
    public int order;

    public GroupItem() { // Required by ObjectBox when an alternate constructor exists
    }

    public GroupItem(@NonNull final Content content, @NonNull final Group group, int order) {
        this.content = content;
        this.group = group;
        this.order = order;
    }

    public GroupItem(long contentId, @NonNull final Group group, int order) {
        this.content = new Content();
        this.content.setId(contentId);
        this.group = group;
        this.order = order;
    }

    @Nullable
    public Content getContent() {
        return content;
    }

    public Group getGroup() {
        return group;
    }

    public long getContentId() {
        return content.getId();
    }

    public long getGroupId() {
        return group.getId();
    }

    public int getOrder() {
        return order;
    }
}
