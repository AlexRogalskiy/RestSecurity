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
package com.wildbeeslabs.api.rest.security.model;

import com.wildbeeslabs.api.rest.common.model.BaseEntity;
import com.wildbeeslabs.api.rest.common.model.validation.UID;
import com.wildbeeslabs.api.rest.common.utils.DateUtils;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Type;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * Account REST Application Model
 *
 * @author Alex
 * @version 1.0.0
 * @since 2017-08-08
 */
@Entity(name = "Account")
@Table(name = "accounts"/*, uniqueConstraints = {
    @UniqueConstraint(columnNames = "name", name = "name_unique_constraint")
}*/)
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends BaseEntity<Long> {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", unique = true, nullable = false)
    private Long id;

    @UID
    @Column(name = "uuid", unique = true, nullable = false, updatable = false)
    @Type(type = "uuid-char")
    private UUID uuId;

//    @OneToOne(mappedBy = "userCredentials", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, optional = false)
//    private UserCredentials credentials;
    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT_PATTERN_EXT)
    @Column(name = "activated_at", nullable = true, insertable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activatedAt;

    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT_PATTERN_EXT)
    @Column(name = "expired_at", nullable = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date expiredAt;

    @PrePersist
    public void initializeUUID() {
        if (Objects.isNull(this.uuId)) {
            this.uuId = UUID.randomUUID();
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    public UUID getUuId() {
        return uuId;
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
        final Account other = (Account) obj;
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
        return String.format("User {id: %d, uuid: %s, activatedAt: %s, expiredAt: %s, inherited: %s}", this.id, this.uuId, this.activatedAt, this.expiredAt, super.toString());
    }
}
