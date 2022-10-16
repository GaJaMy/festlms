package com.zerobase.festlms.member.repository;

import com.zerobase.festlms.member.entity.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistoryMemberRepository extends JpaRepository<MemberHistory, String> {
    Optional<List<MemberHistory>> findByUserIdOrderByLoginDtDesc(String userId);
}
