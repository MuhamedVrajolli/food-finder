package foodfinder.gui;

import foodfinder.pageable.Page;
import foodfinder.pageable.Pageable;
import foodfinder.foodservice.FoodService;
import foodfinder.foodservice.FoodServiceImpl;
import foodfinder.models.FilterModel;
import foodfinder.models.FoodsModel;
import foodfinder.pageable.Sort;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author medi
 */
public class MainForm extends javax.swing.JFrame {
    private final FoodService foodService;
    private final int pageSize = 15;
    private int totalPages;
    private int rowPanelCounter;
    private int pageCounter;
    private boolean sortByNameDirection;
    private boolean sortByPreparationTimeDirection;

    /**
     * Creates new form Test
     */
    public MainForm() {
        foodService = new FoodServiceImpl();
        
        initComponents();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/logo.jpg")).getImage());
        
        //fill first page
        setupContent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        nameHeaderPanel = new javax.swing.JPanel();
        nameHeaderLabel = new javax.swing.JLabel();
        sortByNameButton = new javax.swing.JButton();
        preparationTimeHeaderPanel = new javax.swing.JPanel();
        preparationTimeHeadeLabel = new javax.swing.JLabel();
        sortByPreparationTimeButton = new javax.swing.JButton();
        priceCategoryHeaderPanel = new javax.swing.JPanel();
        priceCategoryHeaderLabel = new javax.swing.JLabel();
        typeHeaderPanel = new javax.swing.JPanel();
        typeHeaderLabel = new javax.swing.JLabel();
        filterHeaderPanel = new javax.swing.JPanel();
        filterComboBox = new javax.swing.JComboBox<>();
        addNewButton = new javax.swing.JButton();
        nextPageButton = new javax.swing.JButton();
        previousPageButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        pageCounterLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        findFoodButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Food Finder");
        setResizable(false);

        headerPanel.setBackground(java.awt.Color.lightGray);
        headerPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        headerPanel.setPreferredSize(new java.awt.Dimension(735, 30));
        headerPanel.setLayout(new java.awt.GridLayout(1, 0));

        nameHeaderPanel.setBackground(java.awt.Color.lightGray);
        nameHeaderPanel.setLayout(new java.awt.GridLayout(1, 0));

        nameHeaderLabel.setText("Name");
        nameHeaderPanel.add(nameHeaderLabel);

        sortByNameButton.setBackground(Color.LIGHT_GRAY);
        sortByNameButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sort.png"))); // NOI18N
        sortByNameButton.setBorder(null);
        sortByNameButton.setPreferredSize(new java.awt.Dimension(28, 20));
        sortByNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByNameButtonActionPerformed(evt);
            }
        });
        nameHeaderPanel.add(sortByNameButton);

        headerPanel.add(nameHeaderPanel);

        preparationTimeHeaderPanel.setBackground(java.awt.Color.lightGray);
        preparationTimeHeaderPanel.setLayout(new java.awt.GridLayout(1, 0));

        preparationTimeHeadeLabel.setText("Prepare Time");
        preparationTimeHeaderPanel.add(preparationTimeHeadeLabel);

        sortByPreparationTimeButton.setBackground(Color.LIGHT_GRAY);
        sortByPreparationTimeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sort.png"))); // NOI18N
        sortByPreparationTimeButton.setBorder(null);
        sortByPreparationTimeButton.setPreferredSize(new java.awt.Dimension(28, 10));
        sortByPreparationTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByPreparationTimeButtonActionPerformed(evt);
            }
        });
        preparationTimeHeaderPanel.add(sortByPreparationTimeButton);

        headerPanel.add(preparationTimeHeaderPanel);

        priceCategoryHeaderPanel.setBackground(java.awt.Color.lightGray);
        priceCategoryHeaderPanel.setLayout(new java.awt.GridLayout(1, 0));

        priceCategoryHeaderLabel.setText("Price Category");
        priceCategoryHeaderPanel.add(priceCategoryHeaderLabel);

        headerPanel.add(priceCategoryHeaderPanel);

        typeHeaderPanel.setBackground(java.awt.Color.lightGray);
        typeHeaderPanel.setLayout(new java.awt.GridLayout(1, 0));

        typeHeaderLabel.setText("Type");
        typeHeaderPanel.add(typeHeaderLabel);

        headerPanel.add(typeHeaderPanel);

        filterHeaderPanel.setBackground(java.awt.Color.lightGray);
        filterHeaderPanel.setLayout(new java.awt.GridLayout(1, 0));

        filterComboBox.setBackground(new Color(238, 238, 238));
        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Foods", "Desserts" }));
        filterComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterComboBoxItemStateChanged(evt);
            }
        });
        filterHeaderPanel.add(filterComboBox);

        headerPanel.add(filterHeaderPanel);

        addNewButton.setBackground(new Color(33, 150, 243));
        addNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addNew.png"))); // NOI18N
        addNewButton.setToolTipText("Add New Food");
        addNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButtonActionPerformed(evt);
            }
        });

        nextPageButton.setBackground(new Color(238, 238, 238));
        nextPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/next.png"))); // NOI18N
        nextPageButton.setBorder(null);
        nextPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPageButtonActionPerformed(evt);
            }
        });

        previousPageButton.setBackground(new Color(238, 238, 238)
        );
        previousPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/previous.png"))); // NOI18N
        previousPageButton.setBorder(null);
        previousPageButton.setEnabled(false);
        previousPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousPageButtonActionPerformed(evt);
            }
        });

        contentPanel.setPreferredSize(new java.awt.Dimension(0, 360));
        contentPanel.setSize(741, 360);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        searchTextField.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        searchButton.setBackground(new Color(33, 150, 243));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        findFoodButton.setBackground(new Color(33, 150, 243));
        findFoodButton.setForeground(java.awt.Color.white);
        findFoodButton.setText("Find A Food");
        findFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFoodButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(previousPageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageCounterLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextPageButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(findFoodButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTextField)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addNewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findFoodButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(previousPageButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nextPageButton))
                    .addComponent(pageCounterLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void previousPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousPageButtonActionPerformed
        rowPanelCounter = 0;
        if(pageCounter == 1){
            previousPageButton.setEnabled(false);
        }
        
        if(pageCounter == totalPages){
            nextPageButton.setEnabled(true);
        }
        
        FilterModel filterModel = getComboBoxFilter(filterComboBox.getSelectedItem().toString());
        
        updateContent(new Pageable(--pageCounter, pageSize, null), searchTextField.getText(), filterModel);
       
        pageCounterLabel.setText("Page "+ (pageCounter+1) + " of " + (totalPages + 1));
    }//GEN-LAST:event_previousPageButtonActionPerformed

    private void nextPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPageButtonActionPerformed
        rowPanelCounter = 0;
        if(pageCounter == 0){
            previousPageButton.setEnabled(true);
        }
        
        if(pageCounter == totalPages - 1){
            nextPageButton.setEnabled(false);
        }
        
        FilterModel filterModel = getComboBoxFilter(filterComboBox.getSelectedItem().toString());
        
        updateContent(new Pageable(++pageCounter, pageSize, null), searchTextField.getText(), filterModel);
        
        pageCounterLabel.setText("Page "+ (pageCounter+1) + " of " + (totalPages + 1));
    }//GEN-LAST:event_nextPageButtonActionPerformed

    private void addNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButtonActionPerformed
        foodDetailsFrameCreator(null);
    }//GEN-LAST:event_addNewButtonActionPerformed

    private void sortByNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByNameButtonActionPerformed
        sortByNameDirection = !sortByNameDirection;
        updateContent(new Pageable(pageCounter, pageSize, new Sort("name", sortByNameDirection? Sort.ASC: Sort.DESC)), searchTextField.getText(), null);
    }//GEN-LAST:event_sortByNameButtonActionPerformed

    private void sortByPreparationTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByPreparationTimeButtonActionPerformed
        sortByPreparationTimeDirection = !sortByPreparationTimeDirection;
        updateContent(new Pageable(pageCounter, pageSize, new Sort("preparation_time", sortByPreparationTimeDirection? Sort.ASC: Sort.DESC)), searchTextField.getText(), null);
    }//GEN-LAST:event_sortByPreparationTimeButtonActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        setDefaults();
        search();
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        setDefaults();
        search();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void filterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String item = evt.getItem().toString();
            setDefaults();

            FilterModel filterModel = getComboBoxFilter(item);
            
            filter(filterModel);
       }
    }//GEN-LAST:event_filterComboBoxItemStateChanged

    private void findFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFoodButtonActionPerformed
        Page<FoodsModel> page = foodService.filter(new Pageable(pageCounter, pageSize, null), null, null);
        
        List<FoodsModel> foods = page.getContent();
        
        if(foods.isEmpty()){
            return;
        }
        
        FindFood f = new FindFood();
        f.setVisible(true);
    }//GEN-LAST:event_findFoodButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JComboBox<String> filterComboBox;
    private javax.swing.JPanel filterHeaderPanel;
    private javax.swing.JButton findFoodButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel nameHeaderLabel;
    private javax.swing.JPanel nameHeaderPanel;
    private javax.swing.JButton nextPageButton;
    private javax.swing.JLabel pageCounterLabel;
    private javax.swing.JLabel preparationTimeHeadeLabel;
    private javax.swing.JPanel preparationTimeHeaderPanel;
    private javax.swing.JButton previousPageButton;
    private javax.swing.JLabel priceCategoryHeaderLabel;
    private javax.swing.JPanel priceCategoryHeaderPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton sortByNameButton;
    private javax.swing.JButton sortByPreparationTimeButton;
    private javax.swing.JLabel typeHeaderLabel;
    private javax.swing.JPanel typeHeaderPanel;
    // End of variables declaration//GEN-END:variables

    private void search(){
        FilterModel filterModel = getComboBoxFilter(filterComboBox.getSelectedItem().toString());
        updateContent(new Pageable(pageCounter, pageSize, null), searchTextField.getText(), filterModel);
    }
    
    private void filter(FilterModel filterModel) {
        updateContent(new Pageable(pageCounter, pageSize, null), null, filterModel);
    }
    
    private void setupContent() {
        updateContent(new Pageable(pageCounter, pageSize, null), null, null);
    }
    
    private void updateContent(Pageable pageable, String search, FilterModel filter){
        rowPanelCounter = 0;
        contentPanel.removeAll();
        contentPanel.revalidate();
        contentPanel.repaint();
        
        Page<FoodsModel> page;
        page = foodService.filter(pageable, filter, search);
        
        List<FoodsModel> foods = page.getContent();
        
        for (FoodsModel foodsModel: foods){
            JPanel rowPanel = rowPanelCreator(foodsModel);
            rowPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
           
            rowPanel.setBounds(0, rowPanelCounter, 1176, 30);
            rowPanel.setVisible(true);
            contentPanel.add(rowPanel);
            contentPanel.revalidate();
            contentPanel.repaint();
            if(rowPanelCounter == 420){
                rowPanelCounter = 0;
            }
            rowPanelCounter+=30;
        }
        
        this.totalPages = page.getTotalPages();
        
        pageCounterLabel.setText("Page "+ (pageCounter+1) + " of " + (totalPages + 1));
        
        if (totalPages == 0) {
            previousPageButton.setEnabled(false);
            nextPageButton.setEnabled(false);
        } else if (totalPages > 0 && pageCounter == 0){
            previousPageButton.setEnabled(false);
            nextPageButton.setEnabled(true);
        } else if (totalPages > 0 && pageCounter == totalPages){
            previousPageButton.setEnabled(true);
            nextPageButton.setEnabled(false);
        }
    }
    
    private JPanel rowPanelCreator(FoodsModel foodsModel){
        JPanel panel = new JPanel();
        
        JLabel nameCellLabel = new JLabel();
        JLabel preparationTimeCellLabel = new JLabel();
        JLabel priceCategoryCellLabel = new JLabel();
        JLabel typeCellLabel = new JLabel();
        
        nameCellLabel.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        nameCellLabel.setText(foodsModel.getName());
        
        preparationTimeCellLabel.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        preparationTimeCellLabel.setText("" + foodsModel.getPreparationTime() + " Minutes");

        priceCategoryCellLabel.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        priceCategoryCellLabel.setText(""+foodService.getPriceCategoryById(foodsModel.getPriceCategory()).getCategory());

        typeCellLabel.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        typeCellLabel.setText(foodsModel.getIsDessert()? "Dessert" : "Food");

        panel.setLayout(new GridLayout());
        panel.add(nameCellLabel);
        panel.add(preparationTimeCellLabel);
        panel.add(priceCategoryCellLabel);
        panel.add(typeCellLabel);
        
        JPanel editColumnPanel = new JPanel();
        editColumnPanel.setLayout(new GridLayout());
        
        JButton editButton = rowButtonCreator("Edit Food", "/icons/edit.png", 
            (ActionEvent evt) -> {
                foodDetailsFrameCreator(foodsModel.getId());
            }
        );
        
        JButton deleteButton = rowButtonCreator("Delete Food", "/icons/delete.png", 
            (ActionEvent evt) -> {
                int result = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this food?", "Delete",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                foodService.delete(foodsModel.getId());
            }
            FilterModel filterModel = getComboBoxFilter(filterComboBox.getSelectedItem().toString());
            updateContent(new Pageable(pageCounter, pageSize, null), searchTextField.getText(), filterModel);
         }
        );
        
        editColumnPanel.add(editButton);
        editColumnPanel.add(deleteButton);
        
        panel.add(editColumnPanel);
        
        return panel;
    }
    
    private JButton rowButtonCreator(String toolTipText, String iconPath, ActionListener actionListener){
        JButton button = new JButton();
        
        button.setText(null);
        button.setBackground(new Color(238, 238, 238));
        button.setBorder(null);
        button.setToolTipText(toolTipText);
        button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        button.addActionListener(actionListener);
        
        return button;
    }

    private void setDefaults() {
        rowPanelCounter = 0;
        pageCounter = 0;
        contentPanel.removeAll();
        contentPanel.removeAll();
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private FilterModel getComboBoxFilter(String item) {
        FilterModel filterModel = new FilterModel();

            switch (item){
                case "Foods":
                    filterModel.setIsDessert(false);
                    break;
                case "Desserts":
                    filterModel.setIsDessert(true);
                    break;
                default:
                    filterModel = null;
            }
        return filterModel;
    }

    private FoodDetails foodDetailsFrameCreator(Long foodId) {
        FoodDetails foodDetails = new FoodDetails(foodId);
        foodDetails.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                FilterModel filterModel = getComboBoxFilter(filterComboBox.getSelectedItem().toString());
                updateContent(new Pageable(pageCounter, pageSize, null), searchTextField.getText(), filterModel);
            }
        });
        foodDetails.pack();
        foodDetails.setLocationRelativeTo(null);
        foodDetails.setVisible(true);
        
        return foodDetails;
    }
}
