package com.projects.devnest.common.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

    public boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public String sanitize(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("<", "&lt;")
                   .replaceAll(">", "&gt;")
                   .replaceAll("\"", "&quot;")
                   .replaceAll("'", "&#39;");
    }

    public String truncate(String str, int length) {
        if (str == null || str.length() <= length) {
            return str;
        }
        return str.substring(0, length) + "...";
    }

    public String toCamelCase(String str) {
        if (isBlank(str)) {
            return str;
        }
        String[] parts = str.split("_");
        StringBuilder result = new StringBuilder(parts[0].toLowerCase());
        for (int i = 1; i < parts.length; i++) {
            result.append(parts[i].substring(0, 1).toUpperCase())
                  .append(parts[i].substring(1).toLowerCase());
        }
        return result.toString();
    }
} 