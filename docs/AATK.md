# Automated accessibility tests availables 

## Adequate Color Contrast Ratio (`TestAdequateContrastRatio`)

Insufficient text and/or image contrast.

**Requirement:** a contrast ratio of at least 4.5:1 must be used.

**Target widgets:** `Button`, `ImageButton`, `ImageView`


## Focus Based Navigation Support (`TestFocusBasedNavigationSuport`)

Confusing interaction and/or navigation.

**Accessibility requirement:** application must support focus based navigation.

**Target widgets:** any `AccessibilityNodeInfo`


## Interaction Element Spacing (`TestInteractionElementSpacing`)

Lack of sufficient spacing between elements.

**Accessibility requirement:** Interaction components must have a minimum spacing of 8dp from each other and from screen edges.


## Form Control Label (`TestMustFormControlHaveLabel`)

Missing component label

**Accessibility requirement:** there must be a TextView with the labelFor attribute associated with it, or it must have the hint attribute provided for each form control.

**Target widgets:** `EditText`, `CheckBox`, `RadioButton`, `Switch`


## Non-textual Content Alternative Text (`TestMustHaveAlternativeText`)

Images and/or icons without textual alternative

**Accessibility requirement:** all non-text content, such as images and media content, must have an alternative text description explaining the content and/or purpose of the element

**Target widgets:** `ImageButton`, `ImageView`


## Touch Target Size (`TestTouchTargetSize`)

Touch target size smaller than recommended

**Accessibility requirement:** touch target must be at least 48x48

**Target widgets:** `Button`, `ImageButton`
