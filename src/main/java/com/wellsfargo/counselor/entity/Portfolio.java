package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;

    @Column(nullable = false)
    private String portfolioName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    // Many portfolios belong to one client
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    // Many-to-many: portfolio contains many securities
    @ManyToMany
    @JoinTable(name = "portfolio_security", joinColumns = @JoinColumn(name = "portfolio_id"), inverseJoinColumns = @JoinColumn(name = "security_id"))
    private List<Security> securities;

    protected Portfolio() {
    }

    public Portfolio(String portfolioName, Date creationDate, Client client) {
        this.portfolioName = portfolioName;
        this.creationDate = creationDate;
        this.client = client;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}