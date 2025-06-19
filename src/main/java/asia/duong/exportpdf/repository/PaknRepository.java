package asia.duong.exportpdf.repository;

import asia.duong.exportpdf.entities.PaknForm;
import asia.duong.exportpdf.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaknRepository extends JpaRepository<PaknForm, Long> {
}
