package com.chase;

import java.util.List;
import java.util.Map;

public interface Consumer {
    boolean consume();
    Map<String, List<Sale>> getSaleLogs();
}
