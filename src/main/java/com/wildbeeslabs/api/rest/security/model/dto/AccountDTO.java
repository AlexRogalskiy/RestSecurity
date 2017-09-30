/*
 * The MIT License
 *
 * Copyright 2017 Pivotal Software, Inc..
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.wildbeeslabs.api.rest.security.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import com.wildbeeslabs.api.rest.common.model.dto.BaseDTO;
import com.wildbeeslabs.api.rest.common.utils.DateUtils;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * AccountDTO REST Application Model
 *
 * @author Alex
 * @version 1.0.0
 * @since 2017-08-08
 */
@Inheritance(strategy = InheritanceType.JOINED)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JacksonXmlRootElement(localName = "account")
public class AccountDTO extends BaseDTO<Long> {

    @JacksonXmlProperty(localName = "id")
    private Long id;

    @JacksonXmlProperty(localName = "uuid")
    //@JacksonInject
    private UUID uuId;

    @JacksonXmlProperty(localName = "activatedAt")
    @JsonProperty("activatedAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DEFAULT_DATE_FORMAT_PATTERN_EXT, locale = DateUtils.DEFAULT_DATE_FORMAT_LOCALE)
    private Date activatedAt;

    @JacksonXmlProperty(localName = "expiredAt")
    @JsonProperty("expiredAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DEFAULT_DATE_FORMAT_PATTERN_EXT, locale = DateUtils.DEFAULT_DATE_FORMAT_LOCALE)
    private Date expiredAt;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public UUID getUuId() {
        return uuId;
    }

    public void setUuId(final UUID uuId) {
        this.uuId = uuId;
    }

    public Date getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(final Date activatedAt) {
        this.activatedAt = activatedAt;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(final Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj || obj.getClass() != this.getClass()) {
            return false;
        }
        final AccountDTO other = (AccountDTO) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.uuId, other.uuId)
                && Objects.equals(this.activatedAt, other.activatedAt)
                && Objects.equals(this.expiredAt, other.expiredAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.uuId, this.activatedAt, this.expiredAt);
    }

    @Override
    public String toString() {
        return String.format("UserDTO {id: %d, uuid: %s, activatedAt: %s, expiredAt: %s, inherited: %s}", this.id, this.uuId, this.activatedAt, this.expiredAt, super.toString());
    }
}
