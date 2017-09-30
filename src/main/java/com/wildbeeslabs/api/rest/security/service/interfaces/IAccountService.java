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
package com.wildbeeslabs.api.rest.security.service.interfaces;

import com.wildbeeslabs.api.rest.common.security.UserCredentials;
import com.wildbeeslabs.api.rest.common.service.interfaces.IBaseService;
import com.wildbeeslabs.api.rest.security.model.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * Account REST Application Service declaration for {@link Account}s.
 *
 * @author Alex
 * @version 1.0.0
 * @since 2017-08-08
 * @param <T>
 */
public interface IAccountService<T extends Account> extends IBaseService<T, Long> {

    /**
     * Returns all {@link Account}s of the given user {@link User}.
     *
     * @param user - user entity
     * @return list of account entities {@link Account}
     */
    List<? extends T> findByUser(final UserCredentials user);

    /**
     * Returns account {@link Account} of the given UUId
     *
     * @param uuId - user identifier
     * @return account entity {@link Account}
     */
    Optional<? extends T> findByUuid(final UUID uuId);
}
