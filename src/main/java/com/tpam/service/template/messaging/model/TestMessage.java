package com.tpam.service.template.messaging.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class TestMessage {

    private final String field1;
    private final String field2;

    public TestMessage(final String field1, final String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final TestMessage that = (TestMessage) o;

        return new EqualsBuilder()
            .append(field1, that.field1)
            .append(field2, that.field2)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(field1)
            .append(field2)
            .toHashCode();
    }
}
