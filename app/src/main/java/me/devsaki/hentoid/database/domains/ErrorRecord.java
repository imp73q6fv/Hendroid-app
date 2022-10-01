package me.devsaki.hentoid.database.domains;

import androidx.annotation.NonNull;

import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import me.devsaki.hentoid.database.converters.InstantConverter;
import me.devsaki.hentoid.enums.ErrorType;

public class ErrorRecord extends RealmObject {

    @PrimaryKey
    public long id;
    private Content content;
    private Integer type;
    private String url;
    private String contentPart;
    private String description;
    private Long timestamp;


    public ErrorRecord() { // Required by ObjectBox when an alternate constructor exists
    }

    public ErrorRecord(ErrorType type, String url, String contentPart, String description, Instant timestamp) {
        this.type = ErrorType.ErrorTypeConverter.convertToDatabaseValue(type);
        this.url = url;
        this.contentPart = contentPart;
        this.description = description;
        this.timestamp = InstantConverter.convertToDatabaseValue(timestamp);
    }

    public ErrorRecord(long contentId, ErrorType type, String url, String contentPart, String description, Instant timestamp) {
        content.setId(contentId);
        this.type = ErrorType.ErrorTypeConverter.convertToDatabaseValue(type);
        this.url = url;
        this.contentPart = contentPart;
        this.description = description;
        this.timestamp = InstantConverter.convertToDatabaseValue(timestamp);
    }


    public ErrorType getType() {
        return ErrorType.ErrorTypeConverter.convertToEntityProperty(type);
    }

    public String getUrl() {
        return url;
    }

    public String getContentPart() {
        return contentPart;
    }

    public String getDescription() {
        return (null == description) ? "" : description;
    }

    public Instant getTimestamp() {
        return (null == timestamp) ? Instant.EPOCH : InstantConverter.convertToEntityProperty(timestamp);
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @NonNull
    @Override
    public String toString() {
        String timeStr = "";
        if (timestamp != null && !timestamp.equals(Instant.EPOCH)) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; // e.g. 2011-12-03T10:15:30
            timeStr = getTimestamp().atZone(ZoneId.systemDefault()).format(formatter) + " ";
        }

        return String.format("%s%s - [%s]: %s @ %s", timeStr, contentPart, getType().getEngName(), description, url);
    }
}
