package me.devsaki.hentoid.database.converters;

import androidx.annotation.Nullable;

import org.threeten.bp.Instant;

public class InstantConverter {
    @Nullable
    public static Instant convertToEntityProperty(Long databaseValue) {
        if (databaseValue == null) return null;
        return Instant.ofEpochMilli(databaseValue);
    }

    @Nullable
    public static Long convertToDatabaseValue(Instant entityProperty) {
        return entityProperty == null ? null : entityProperty.toEpochMilli();
    }
}