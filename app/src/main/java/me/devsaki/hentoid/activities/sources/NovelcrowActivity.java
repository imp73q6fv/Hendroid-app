package me.devsaki.hentoid.activities.sources;

import me.devsaki.hentoid.enums.Site;

public class NovelcrowActivity extends BaseWebActivity {

    private static final String DOMAIN_FILTER = "novelcrow.com";
    private static final String[] GALLERY_FILTER = {"//novelcrow.com/novel/[%\\w\\-]+[/]{0,1}$"};
    private static final String[] DIRTY_ELEMENTS = {".ads", ".advertisement"};

    Site getStartSite() {
        return Site.NOVELCROW;
    }

    @Override
    protected CustomWebViewClient createWebClient() {
        CustomWebViewClient client = new CustomWebViewClient(getStartSite(), GALLERY_FILTER, this);
        client.restrictTo(DOMAIN_FILTER);
        client.addRemovableElements(DIRTY_ELEMENTS);
        return client;
    }
}
