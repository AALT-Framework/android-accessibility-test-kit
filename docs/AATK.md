# Automated accessibility tests availables 

## Adequate Color Contrast Ratio (`TestAdequateContrastRatio`)

### Accessibility issue
Insufficient text and/or image contrast.

**Requirement:** a contrast ratio of at least 4.5:1 must be used.

**Target widgets:** `Button`, `ImageButton`, `ImageView`


## Interaction Element Spacing (`TestInteractionElementSpacing`)

### Accessibility issue
Lack of sufficient spacing between elements.

**Accessibility requirement:** Interaction components must have a minimum spacing of 8dp from each other and from screen edges.


## Form Control Label (`TestMustFormControlHaveLabel`)

### Accessibility issue
Missing component label

**Accessibility requirement:** there must be a TextView with the labelFor attribute associated with it, or it must have the hint attribute provided for each form control.

**Target widgets:** `EditText`, `CheckBox`, `RadioButton`, `Switch`


## Non-textual Content Alternative Text (`TestMustHaveAlternativeText`)

### Accessibility issue
Images and/or icons without textual alternative

**Accessibility requirement:** all non-text content, such as images and media content, must have an alternative text description explaining the content and/or purpose of the element

**Target widgets:** `ImageButton`, `ImageView`


## Touch Target Size (`TestTouchTargetSize`)

### Accessibility issue
Touch target size smaller than recommended

**Accessibility requirement:** touch target must be at least 48x48

**Target widgets:** `Button`, `ImageButton`
