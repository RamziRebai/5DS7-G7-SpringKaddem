package tn.esprit.spring.khaddem;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Equipe;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.repositories.EquipeRepository;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;
import tn.esprit.spring.khaddem.services.EtudiantServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EtudiantServiceImplTest {

    @InjectMocks
    private EtudiantServiceImpl etudiantService;


    @Mock
    private EtudiantRepository etudiantRepository;

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EquipeRepository equipeRepository;

    public EtudiantServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddAndAssignEtudiantToEquipeAndContract() {
        // Arrange
        Etudiant etudiant = new Etudiant(/* initialize etudiant */);
        Contrat contrat = new Contrat(/* initialize contrat */);
        Equipe equipe = new Equipe(/* initialize equipe */);

        when(etudiantRepository.save(any())).thenReturn(etudiant);
        when(contratRepository.findById(any())).thenReturn(Optional.of(contrat));
        when(equipeRepository.findById(any())).thenReturn(Optional.of(equipe));

        // Act
        Etudiant result = etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant, 1, 1);

        // Assert
        assertEquals(etudiant, result);
        assertEquals(1, etudiant.getEquipes().size());
        verify(contrat).setEtudiant(etudiant);
    }

    // Add more tests for other methods in EtudiantServiceImpl if needed
}

