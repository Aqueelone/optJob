package ua.acceptic.optjob.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A BlackList.
 */
@Entity
@Table(name = "black_list")
public class BlackList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "blackList")
    @JsonIgnore
    private Set<Publisher> publishers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public BlackList publishers(Set<Publisher> publishers) {
        this.publishers = publishers;
        return this;
    }

    public BlackList addPublishers(Publisher publisher) {
        this.publishers.add(publisher);
        publisher.setBlackList(this);
        return this;
    }

    public BlackList removePublishers(Publisher publisher) {
        this.publishers.remove(publisher);
        publisher.setBlackList(null);
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
        BlackList blackList = (BlackList) o;
        if (blackList.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), blackList.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BlackList{" +
            "id=" + getId() +
            "}";
    }
}
