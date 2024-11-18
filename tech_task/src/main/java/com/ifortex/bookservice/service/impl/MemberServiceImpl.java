package com.ifortex.bookservice.service.impl;

import com.ifortex.bookservice.model.Member;
import com.ifortex.bookservice.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class MemberServiceImpl implements MemberService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Member findMember() {
        //находим самую старую книгу и самго нового участника который прочитал ее
        String sql = """
                    SELECT m.*
                    FROM members m
                    JOIN member_books mb ON m.id = mb.member_id
                    JOIN books b ON b.id = mb.book_id
                    WHERE 'Romance' = ANY(b.genre)
                    ORDER BY b.publication_date ASC, m.membership_date DESC
                    LIMIT 1
                """;
        return (Member) entityManager.createNativeQuery(sql, Member.class).getSingleResult();
    }


    @Override
    public List<Member> findMembers() {
        String sql = """
                    SELECT m.*
                    FROM members m
                    LEFT JOIN member_books mb ON m.id = mb.member_id
                    WHERE mb.book_id IS NULL
                    AND EXTRACT(YEAR FROM m.membership_date) = 2023
                """;

        return entityManager.createNativeQuery(sql, Member.class).getResultList();
    }
}
