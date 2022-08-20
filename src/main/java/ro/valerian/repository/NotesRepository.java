package ro.valerian.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.valerian.entity.Notes;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

    @Query("FROM Notes AS n WHERE n.userDtls.id=:uid")
    public Page<Notes> findNotesByUser(@Param("uid") int uid, Pageable p);
}
