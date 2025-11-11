package com.folioreader.util;

import com.folioreader.FolioReader;

/**
 * Interface to convey highlight events.
 *
 * @author gautam chibde on 26/9/17.
 */

public interface OnClosedListener {
    /**
     * You may call {@link FolioReader#clear()} in this method, if you wouldn't require to open
     * an epub again from the current activity.
     * Or you may call {@link FolioReader#stop()} in this method, if you wouldn't require to open
     * an epub again from your application.
     */
    void onFolioReaderClosed();
}
