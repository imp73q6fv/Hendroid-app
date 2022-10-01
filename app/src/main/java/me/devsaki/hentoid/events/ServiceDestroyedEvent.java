package me.devsaki.hentoid.events;

import androidx.annotation.IdRes;

public class ServiceDestroyedEvent {
    public final @PrimaryKeyRes
    int service;

    public ServiceDestroyedEvent(@PrimaryKeyRes int service) {
        this.service = service;
    }
}
