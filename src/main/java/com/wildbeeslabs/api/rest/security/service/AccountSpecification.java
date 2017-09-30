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
package com.wildbeeslabs.api.rest.security.service;

import com.wildbeeslabs.api.rest.security.model.Account;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * Account REST Application Specification implementation {@link Account}
 *
 * @author Alex
 * @version 1.0.0
 * @since 2017-08-08
 */
public class AccountSpecification {

    /**
     * All customers with an {@link Account} expiring before the given date.
     *
     * @param date - expiration date
     * @return account specification
     * @param <T>
     */
    public static <T extends Account> Specification<T> accountExpiresBefore(final Date date) {

        return (final Root<T> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) -> {
            Root<Account> accounts = query.from(Account.class);
            Path<Date> expiryDate = accounts.<Date>get("expiredAt");
            Predicate customerIsAccountOwner = cb.equal(accounts.<T>get("user"), root);
            Predicate accountExpiryDateBefore = cb.lessThan(expiryDate, date);
            return cb.and(customerIsAccountOwner, accountExpiryDateBefore);
        };
    }
}
