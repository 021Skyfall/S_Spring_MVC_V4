package IO.SampleWeek23SpringDataJPA.member.service;

import IO.SampleWeek23SpringDataJPA.exception.BusinessLogicException;
import IO.SampleWeek23SpringDataJPA.exception.ExceptionCode;
import IO.SampleWeek23SpringDataJPA.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    // 회원 정보 등록
    public Member createMember(Member member) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
    // 회원 정보 수정
    public Member updateMember(Member member) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
    // 회원 조회
    public Member findMember(long memberId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
    // 전체 회원 조회
    public Page<Member> findMembers(int page, int size) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
    // 회원 삭제
    public void deleteMember(long memberId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    // 이미 존재하는 회원인지 검증
    public Member findVerifiedMember(long memberId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    // 이미 존재하는 이메일인지 검증
    private void verifyExistsEmail(String email) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
}
