package org.example.component.column;

import org.example.component.Column;

public class TypeHTML extends Column {
    public TypeHTML(String name) {
        super(name);
    }

    @Override
    public boolean validate(String value) {
        return value.toLowerCase().endsWith(".html");
    }
}