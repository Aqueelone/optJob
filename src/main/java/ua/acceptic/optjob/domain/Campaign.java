package ua.acceptic.optjob.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Campaign.
 */
@Entity
@Table(name = "campaign")
public class Campaign implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(unique = true)
    private OptimizationProps optimizationProps;

    @OneToOne
    @JoinColumn(unique = true)
    private BlackList blacklist;

    @OneToMany(mappedBy = "campaign")
    @JsonIgnore
    private Set<Publisher> publishers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Campaign name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OptimizationProps getOptimizationProps() {
        return optimizationProps;
    }

    public Campaign optimizationProps(OptimizationProps optimizationProps) {
        this.optimizationProps = optimizationProps;
        return this;
    }

    public void setOptimizationProps(OptimizationProps optimizationProps) {
        this.optimizationProps = optimizationProps;
    }

    public BlackList getBlacklist() {
        return blacklist;
    }

    public Campaign blacklist(BlackList blackList) {
        this.blacklist = blackList;
        return this;
    }

    public void setBlacklist(BlackList blackList) {
        this.blacklist = blackList;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public Campaign publishers(Set<Publisher> publishers) {
        this.publishers = publishers;
        return this;
    }

    public Campaign addPublishers(Publisher publisher) {
        this.publishers.add(publisher);
        publisher.setCampaign(this);
        return this;
    }

    public Campaign removePublishers(Publisher publisher) {
        this.publishers.remove(publisher);
        publisher.setCampaign(null);
        return this;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Campaign campaign = (Campaign) o;
        if (campaign.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), campaign.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Campaign{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
