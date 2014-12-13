package de.dpunkt.myaktion.model;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Campaign.findAll, query = "SELECT a FROM Campaign a ORDER BY a.name"),
        @NamedQuery(name = Campaign.getAmountDonatedSoFar, query = "SELECT SUM(d.amount) FROM Donation d WHERE d.campaign = :campaign")
})
@Entity
public class Campaign {
    public static final String findAll = "Campaign.findAll";
    public static final String getAmountDonatedSoFar = "Campaign.getAmountDonatedSoFar";
    private String name;
    private Double targetAmount;
    private Double donationMinimum;
    private Double amountDonatedSoFar;
    @AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "accountName"))})
    @Embedded
    private Account account;
    @GeneratedValue
    @Id
    private Long id;
    @OneToMany(mappedBy = "campaign")
    private List<Donation> donations;

    public Campaign() {
        account = new Account();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Double getDonationMinimum() {
        return donationMinimum;
    }

    public void setDonationMinimum(Double donationMinimum) {
        this.donationMinimum = donationMinimum;
    }

    public Double getAmountDonatedSoFar() {
        return amountDonatedSoFar;
    }

    public void setAmountDonatedSoFar(Double amountDonatedSoFar) {
        this.amountDonatedSoFar = amountDonatedSoFar;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

}
