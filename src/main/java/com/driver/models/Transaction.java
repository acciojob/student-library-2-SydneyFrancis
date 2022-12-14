package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Builder
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionId = UUID.randomUUID().toString(); // externalId

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("books")
    private Card card;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("transactions")
    private Book book;

    private int fineAmount;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean isIssueOperation;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    public Transaction(int id, String transactionId, Card card, Book book, int fineAmount, boolean isIssueOperation, TransactionStatus transactionStatus, Date transactionDate) {
        this.id = id;
        this.transactionId = transactionId;
        this.card = card;
        this.book = book;
        this.fineAmount = fineAmount;
        this.isIssueOperation = isIssueOperation;
        this.transactionStatus = transactionStatus;
        this.transactionDate = transactionDate;
    }

    public Transaction() {
    }

    @CreationTimestamp
    private Date transactionDate;
}

