package IO.SampleWeek23SpringDataJPA.member.controller;

import IO.SampleWeek23SpringDataJPA.response.PageResponseDto;
import IO.SampleWeek23SpringDataJPA.member.dto.MemberPatchDto;
import IO.SampleWeek23SpringDataJPA.member.dto.MemberPostDto;
import IO.SampleWeek23SpringDataJPA.member.dto.MemberResponseDto;
import IO.SampleWeek23SpringDataJPA.member.entity.Member;
import IO.SampleWeek23SpringDataJPA.response.PageInfo;
import IO.SampleWeek23SpringDataJPA.member.mapper.MemberMapper;
import IO.SampleWeek23SpringDataJPA.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/members")
@AllArgsConstructor
@Validated
@Slf4j
public class MemberController {
    private final MemberService service;
    private final MemberMapper mapper;
    @PostMapping
    public ResponseEntity postMember(@Validated @RequestBody MemberPostDto memberPostDto){

        Member response = service.createMember(mapper.memberPostDtoToMember(memberPostDto));
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Validated @RequestBody MemberPatchDto memberPatchDto){
        memberPatchDto.setMemberId(memberId);

        Member member = service.updateMember(mapper.memberPatchDtoToMember(memberPatchDto));
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(member),HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId){

        Member member = service.findMember(memberId);
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(member),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size){

        Page<Member> memberPage = service.findMembers(page-1,size);
        List<Member> members = memberPage.getContent();

        return new ResponseEntity<>(new PageResponseDto<>(
                mapper.membersToMemberResponseDtos(members),memberPage),HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId){
        service.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
