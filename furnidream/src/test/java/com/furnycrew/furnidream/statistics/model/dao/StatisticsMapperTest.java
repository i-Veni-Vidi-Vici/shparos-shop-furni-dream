package com.furnycrew.furnidream.statistics.model.dao;


import static org.assertj.core.api.Assertions.assertThat;

import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StatisticsMapperTest {

    @Autowired
    private StatisticsMapper menuMapper;

    @DisplayName("[모든 기간/전체] 상품별 주문량 내림차순 정렬로 가져오기")
    @Test
    void calculateOrderCountRankByAllPeriod() {
        // given
        // when
        List<OrderCountRankingDto> result = menuMapper.calculateOrderCountRankByAllPeriod();

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
//        for (OrderCountRankingDto orderCountRankingDto : result) {
//            System.out.println(orderCountRankingDto);
//        }
    }

    @DisplayName("[분기별/전체] 상품별 주문량 내림차순 정렬로 가져오기")
    @Test
    void  calculateOrderCountRankByQuarterPeriod(){
        // given
        // when
        List<OrderCountRankingDto> result = menuMapper.calculateOrderCountRankByQuarterPeriod(2024, 2);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);

    }

}