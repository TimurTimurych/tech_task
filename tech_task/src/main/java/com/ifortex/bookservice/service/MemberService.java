package com.ifortex.bookservice.service;

import com.ifortex.bookservice.model.Book;
import com.ifortex.bookservice.model.Member;

import java.util.List;

// Attention! It is FORBIDDEN to make any changes in this file!
public interface MemberService {
  /**
   * Finds the {@link Member} who has read the oldest “Romance” genre {@link Book} and was most
   * recently registered on the platform
   *
   * @return desired member
   */
  Member findMember();

  /**
   * Finds {@link Member}s who register in 2023 year but didn't read any {@link Book}s
   *
   * @return desired member
   */
  List<Member> findMembers();
}
