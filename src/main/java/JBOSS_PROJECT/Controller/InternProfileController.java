package JBOSS_PROJECT.Controller;

import JBOSS_PROJECT.ENTITY.InternProfile;
import JBOSS_PROJECT.JPArepo.InternProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interns")
public class InternProfileController {

    @Autowired
    private InternProfileRepository internProfileRepository;

    @GetMapping
    public List<InternProfile> getAllInterns() {
        return internProfileRepository.findAll();
    }

    @PostMapping
    public InternProfile createInternProfile(@RequestBody InternProfile internProfile) {
        return internProfileRepository.save(internProfile);
    }

    @GetMapping("/{id}")
    public Optional<InternProfile> getInternProfileById(@PathVariable Long id) {
        return internProfileRepository.findById(id);
    }

    @PutMapping("/{id}")
    public InternProfile updateInternProfile(@PathVariable Long id, @RequestBody InternProfile internProfile) {
        internProfile.setId(id); // Set the ID of the updated entity
        return internProfileRepository.save(internProfile);
    }

    @DeleteMapping("/{id}")
    public void deleteInternProfile(@PathVariable Long id) {
        internProfileRepository.deleteById(id);
    }
}
