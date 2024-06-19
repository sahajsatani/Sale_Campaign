package com.salecampaign.amazon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblcampaign")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int campaignId;

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;


    @OneToMany(mappedBy = "campaign", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Discount> discounts = new ArrayList<>();

    public Campaign setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate);
        return this;
    }

    public Campaign setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate);
        return this;
    }

}
