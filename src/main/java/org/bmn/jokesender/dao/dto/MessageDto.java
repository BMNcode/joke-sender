package org.bmn.jokesender.dao.dto;

import java.util.Objects;

public class MessageDto {
    private String text;

    public MessageDto() {
    }

    public MessageDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDto that = (MessageDto) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "text='" + text + '\'' +
                '}';
    }
}
