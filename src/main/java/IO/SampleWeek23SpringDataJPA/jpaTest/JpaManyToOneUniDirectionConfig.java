package IO.SampleWeek23SpringDataJPA.jpaTest;

import IO.SampleWeek23SpringDataJPA.member.entity.Member;
import IO.SampleWeek23SpringDataJPA.order.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaManyToOneUniDirectionConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaManyToOneRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
//            mappingManyToOneUniDirection();
//            mappingManyToOneBiDirection();
        };
    }

    private void mappingManyToOneBiDirection() {
        tx.begin();

        Member member = new Member("hgd@gmail.com", "Hong Gil Dong",
                "010-1111-1111");
        Order order = new Order();

        member.addOrder(order);
        order.setMember(member);

        em.persist(member);
        em.persist(order);

        tx.commit();

        Member findMember = em.find(Member.class, 1L);

        findMember.getOrders()
                .stream()
                .forEach(findOrder -> {
                    System.out.printf("findOrder : %s , %s",findOrder.getOrderId(),
                            findOrder.getOrderStatus());
                });
    }

//    private void mappingManyToOneUniDirection() {
//        tx.begin();
//
//        Member member = new Member("hgd@gmail.com", "Hong Gil Dong",
//        "010-1111-1111");
//        em.persist(member);
//
//        Order order = new Order();
//        order.addMember(member);
//        em.persist(order);
//
//        tx.commit();
//
//        // (4)
//        Order findOrder = em.find(Order.class,1L);
//
//        // (5)
//        System.out.printf("Who ordered : %d , %s , %s , %s",
//                findOrder.getMember().getMemberId(),findOrder.getMember().getEmail(),
//                findOrder.getMember().getName(),findOrder.getMember().getPhone());
//    }
}
