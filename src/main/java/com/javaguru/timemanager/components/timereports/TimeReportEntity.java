package com.javaguru.timemanager.components.timereports;

import com.javaguru.timemanager.components.projects.ProjectEntity;
import com.javaguru.timemanager.components.users.UserEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "timereports")
public class TimeReportEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hours")
    private BigDecimal hours;

    @Version
    @Column(name = "version")
    private Integer version;

    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hour) {
        this.hours = hour;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeReportEntity that = (TimeReportEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(hours, that.hours) &&
                Objects.equals(version, that.version) &&
                Objects.equals(created, that.created) &&
                Objects.equals(updated, that.updated) &&
                Objects.equals(project, that.project) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hours, version, created, updated, project, user);
    }

    @Override
    public String toString() {
        return "TimeReportEntity{" +
                "id=" + id +
                ", hours=" + hours +
                ", version=" + version +
                ", created=" + created +
                ", updated=" + updated +
                ", project=" + project +
                ", user=" + user +
                '}';
    }
}
